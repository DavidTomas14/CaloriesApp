package com.davidtomas.domain.model

sealed class MealType(val name: String) {
    object Breakfast : MealType(BREAKFAST)
    object Lunch : MealType(LUNCH)
    object Dinner : MealType(DINNER)
    object Snack : MealType(SNACK)

    companion object {
        const val BREAKFAST = "breakfast"
        const val LUNCH = "lunch"
        const val DINNER = "dinner"
        const val SNACK = "snacks"
        fun fromString(name: String): MealType {
            return when (name.lowercase()) {
                BREAKFAST -> Breakfast
                LUNCH -> Lunch
                DINNER -> Dinner
                SNACK -> Snack
                else -> Breakfast
            }
        }
    }
}
