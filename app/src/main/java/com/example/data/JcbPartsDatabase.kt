package com.example.data

import com.example.model.*

/**
 * Complete Offline Trilingual (English, Hindi, Arabic RTL) Parts Image Library
 * Covers all 15 JCB & Backhoe Loader Categories with dedicated 1-part-per-image studio HD photos.
 */
object JcbPartsDatabase {

    val parts: List<JcbPart> = JcbPartsGroupA.parts + JcbPartsGroupB.parts

    fun getByCategory(category: SystemCategory): List<JcbPart> =
        parts.filter { it.system == category }

    fun searchParts(
        query: String,
        categoryFilter: SystemCategory? = null,
        modelFilter: String? = null
    ): List<JcbPart> {
        val q = query.trim().lowercase()
        return parts.filter { part ->
            val matchesCat = categoryFilter == null || part.system == categoryFilter
            val matchesModel = modelFilter == null ||
                part.supportedModels.any { it.contains(modelFilter, ignoreCase = true) }
            val matchesText = q.isEmpty() ||
                part.nameEn.lowercase().contains(q) ||
                part.nameHi.lowercase().contains(q) ||
                part.nameAr.lowercase().contains(q) ||
                part.partNumber.lowercase().contains(q) ||
                part.system.titleEn.lowercase().contains(q) ||
                part.system.titleHi.lowercase().contains(q) ||
                part.system.titleAr.lowercase().contains(q) ||
                part.location.en.lowercase().contains(q) ||
                part.location.hi.lowercase().contains(q) ||
                part.location.ar.lowercase().contains(q)
            matchesCat && matchesModel && matchesText
        }
    }
}
