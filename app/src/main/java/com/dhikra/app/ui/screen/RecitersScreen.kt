package com.dhikra.app.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dhikra.app.ui.components.DhikraButton
import com.dhikra.app.ui.components.DhikraCard

@Composable
fun RecitersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "قراء القرآن",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right
        )

        Spacer(modifier = Modifier.height(16.dp))

        val reciters = listOf(
            "عبد الباسط عبد الصمد",
            "محمد صديق المنشاوي",
            "محمود خليل الحصري",
            "مصطفى إسماعيل",
            "عبد الرحمن السديس",
            "سعود الشريم",
            "ماهر المعيقلي",
            "ياسر الدوسري",
            "مشاري راشد العفاسي",
            "فارس عباد"
        )

        reciters.forEach { reciter ->
            DhikraCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = reciter,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    DhikraButton(
                        text = "▶ تشغيل",
                        onClick = { },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
