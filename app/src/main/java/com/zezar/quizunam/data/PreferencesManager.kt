package com.zezar.quizunam.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

// ✅ A NIVEL DE ARCHIVO (fuera de cualquier clase/objeto)
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "subject_prefs")

object PreferencesManager {

    suspend fun saveProgress(context: Context, key: String, value: Int) {
        val prefKey = intPreferencesKey(key)
        context.dataStore.edit { prefs ->
            prefs[prefKey] = value
        }
    }

    suspend fun getProgress(context: Context, key: String): Int {
        val prefKey = intPreferencesKey(key)
        val prefs = context.dataStore.data.first()
        return prefs[prefKey] ?: 0
    }

}

