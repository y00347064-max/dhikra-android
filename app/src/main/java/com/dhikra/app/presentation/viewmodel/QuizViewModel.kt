package com.dhikra.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhikra.app.domain.model.QuizQuestion
import com.dhikra.app.domain.model.UserProgress
import com.dhikra.app.domain.repository.QuizRepository
import com.dhikra.app.domain.repository.UserProgressRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizViewModel(
    private val quizRepository: QuizRepository,
    private val progressRepository: UserProgressRepository
) : ViewModel() {

    private val _questions = MutableStateFlow<List<QuizQuestion>>(emptyList())
    val questions: StateFlow<List<QuizQuestion>> = _questions.asStateFlow()

    private val _currentQuestion = MutableStateFlow<QuizQuestion?>(null)
    val currentQuestion: StateFlow<QuizQuestion?> = _currentQuestion.asStateFlow()

    private val _currentLevel = MutableStateFlow(1)
    val currentLevel: StateFlow<Int> = _currentLevel.asStateFlow()

    private val _xp = MutableStateFlow(0)
    val xp: StateFlow<Int> = _xp.asStateFlow()

    private val _userProgress = MutableStateFlow<UserProgress?>(null)
    val userProgress: StateFlow<UserProgress?> = _userProgress.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun loadQuestionsByLevel(category: String, level: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            val difficulty = when (level) {
                1 -> "Easy"
                2 -> "Easy"
                3 -> "Medium"
                4 -> "Hard"
                5 -> "Hard"
                else -> "Expert"
            }
            quizRepository.getQuestionsByCategoryAndDifficulty(category, difficulty)
                .collect { questions ->
                    _questions.value = questions
                    if (questions.isNotEmpty()) {
                        _currentQuestion.value = questions.first()
                    }
                    _isLoading.value = false
                }
        }
    }

    fun answerQuestion(questionId: String, selectedAnswerIndex: Int, isCorrect: Boolean) {
        viewModelScope.launch {
            if (isCorrect) {
                val currentXp = _xp.value
                val question = _currentQuestion.value
                _xp.value = currentXp + (question?.xpReward ?: 10)

                // Move to next level automatically
                val nextLevel = _currentLevel.value + 1
                if (nextLevel <= 6) {
                    _currentLevel.value = nextLevel
                }
            }
        }
    }

    fun loadUserProgress(userId: String) {
        viewModelScope.launch {
            progressRepository.getUserProgress(userId).collect { progress ->
                _userProgress.value = progress
            }
        }
    }
}
