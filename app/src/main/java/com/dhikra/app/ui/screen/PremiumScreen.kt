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
fun PremiumScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "DHIKRA Premium 👑",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        DhikraCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "المزايا:",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "✓ بدون إعلانات\n✓ 12 مؤذن Premium\n✓ 30 ثيم Premium\n✓ إحصائيات متقدمة\n✓ تخصيص متقدم",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Right
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "الخطط:",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right
        )

        Spacer(modifier = Modifier.height(8.dp))

        DhikraButton(
            text = "3 أشهر - 4.99 دولار",
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            isPremium = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        DhikraButton(
            text = "6 أشهر - 8.99 دولار",
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            isPremium = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        DhikraButton(
            text = "سنة - 14.99 دولار",
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            isPremium = true
        )
    }
}
