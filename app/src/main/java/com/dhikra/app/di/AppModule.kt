package com.dhikra.app.di

import com.dhikra.app.data.local.AppDatabase
import com.dhikra.app.data.repository.AzkarRepositoryImpl
import com.dhikra.app.data.repository.AyahRepositoryImpl
import com.dhikra.app.data.repository.BookmarkRepositoryImpl
import com.dhikra.app.data.repository.MuezzinRepositoryImpl
import com.dhikra.app.data.repository.PrayerTimesRepositoryImpl
import com.dhikra.app.data.repository.QuizRepositoryImpl
import com.dhikra.app.data.repository.ReciterRepositoryImpl
import com.dhikra.app.data.repository.SettingsRepositoryImpl
import com.dhikra.app.data.repository.SurahRepositoryImpl
import com.dhikra.app.data.repository.TasbihRepositoryImpl
import com.dhikra.app.data.repository.ThemeRepositoryImpl
import com.dhikra.app.data.repository.UserProgressRepositoryImpl
import com.dhikra.app.domain.repository.AzkarRepository
import com.dhikra.app.domain.repository.AyahRepository
import com.dhikra.app.domain.repository.BookmarkRepository
import com.dhikra.app.domain.repository.MuezzinRepository
import com.dhikra.app.domain.repository.PrayerTimesRepository
import com.dhikra.app.domain.repository.QuizRepository
import com.dhikra.app.domain.repository.ReciterRepository
import com.dhikra.app.domain.repository.SettingsRepository
import com.dhikra.app.domain.repository.SurahRepository
import com.dhikra.app.domain.repository.TasbihRepository
import com.dhikra.app.domain.repository.ThemeRepository
import com.dhikra.app.domain.repository.UserProgressRepository
import com.dhikra.app.presentation.viewmodel.PrayerViewModel
import com.dhikra.app.presentation.viewmodel.QuizViewModel
import com.dhikra.app.presentation.viewmodel.QuranViewModel
import com.dhikra.app.presentation.viewmodel.SettingsViewModel
import com.dhikra.app.presentation.viewmodel.TasbihViewModel
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Database
    single { AppDatabase.getDatabase(androidContext()) }

    // DAOs
    single { get<AppDatabase>().surahDao() }
    single { get<AppDatabase>().ayahDao() }
    single { get<AppDatabase>().bookmarkDao() }
    single { get<AppDatabase>().reciterDao() }
    single { get<AppDatabase>().muezzinDao() }
    single { get<AppDatabase>().azkarDao() }
    single { get<AppDatabase>().tasbihDao() }
    single { get<AppDatabase>().quizQuestionDao() }
    single { get<AppDatabase>().userProgressDao() }
    single { get<AppDatabase>().themeDao() }
    single { get<AppDatabase>().settingsDao() }

    // Repositories
    single<SurahRepository> { SurahRepositoryImpl(get()) }
    single<AyahRepository> { AyahRepositoryImpl(get()) }
    single<BookmarkRepository> { BookmarkRepositoryImpl(get()) }
    single<ReciterRepository> { ReciterRepositoryImpl(get(), Gson()) }
    single<MuezzinRepository> { MuezzinRepositoryImpl(get()) }
    single<PrayerTimesRepository> { PrayerTimesRepositoryImpl() }
    single<AzkarRepository> { AzkarRepositoryImpl(get()) }
    single<TasbihRepository> { TasbihRepositoryImpl(get()) }
    single<QuizRepository> { QuizRepositoryImpl(get(), Gson()) }
    single<UserProgressRepository> { UserProgressRepositoryImpl(get(), Gson()) }
    single<ThemeRepository> { ThemeRepositoryImpl(get()) }
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }

    // ViewModels
    viewModel { QuranViewModel(get()) }
    viewModel { PrayerViewModel(get()) }
    viewModel { TasbihViewModel(get()) }
    viewModel { QuizViewModel(get(), get()) }
    viewModel { SettingsViewModel(get(), get()) }
}
