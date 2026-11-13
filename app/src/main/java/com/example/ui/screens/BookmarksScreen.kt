package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkRemove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.data.JcbPartsDatabase
import com.example.model.AppLanguage
import com.example.model.JcbPart
import com.example.model.tr
import com.example.ui.theme.JcbYellow

@Composable
fun BookmarksScreen(
    language: AppLanguage,
    bookmarkedPartIds: Set<String>,
    onToggleBookmark: (String) -> Unit,
    onSelectPart: (JcbPart) -> Unit,
    modifier: Modifier = Modifier
) {
    val bookmarkedParts = JcbPartsDatabase.parts.filter { bookmarkedPartIds.contains(it.id) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("bookmarks_screen")
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = tr(language, "Saved Favorite Parts", "सहेजे गए जरूरी पुर्जे", "القطع المحفوظة في المفضلة"),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${bookmarkedParts.size} ${tr(language, "items", "पार्ट्स", "قطعة")}",
                style = MaterialTheme.typography.labelSmall,
                color = JcbYellow,
                fontWeight = FontWeight.Bold
            )
        }

        if (bookmarkedParts.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.BookmarkRemove,
                        contentDescription = null,
                        modifier = Modifier.size(60.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = tr(
                            language,
                            "No bookmarks saved yet. Tap the bookmark icon on any part to save for quick offline access.",
                            "कोई बुकमार्क नहीं मिला। पार्ट्स कैटलॉग में बुकमार्क आइकॉन दबाकर सहेजें।",
                            "لا توجد قطع محفوظة بعد. اضغط على أيقونة الحفظ بجانب أي قطعة للوصول السريع دون إنترنت."
                        ),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(bookmarkedParts, key = { it.id }) { part ->
                    PartItemCard(
                        part = part,
                        language = language,
                        isBookmarked = true,
                        onToggleBookmark = { onToggleBookmark(part.id) },
                        onClick = { onSelectPart(part) }
                    )
                }
            }
        }
    }
}
