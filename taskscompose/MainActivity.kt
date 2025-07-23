package com.example.taskscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.taskscompose.data.NoteDatabase
import com.example.taskscompose.repository.NoteRepository
import com.example.taskscompose.ui.screens.AddEditNoteScreen
import com.example.taskscompose.ui.screens.NoteListScreen
import com.example.taskscompose.ui.theme.TasksComposeTheme
import com.example.taskscompose.viewmodel.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = NoteDatabase.getDatabase(this).noteDao()
        val repository = NoteRepository(dao)
        val viewModel = NoteViewModel(repository)

        viewModel.deleteAllNotes()

        setContent {
            var isDarkTheme by rememberSaveable { mutableStateOf(false) }

            TasksComposeTheme(darkTheme = isDarkTheme) {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "list") {
                    composable("list") {
                        NoteListScreen(
                            navController = navController,
                            viewModel = viewModel,
                            isDarkTheme = isDarkTheme,
                            onToggleTheme = { isDarkTheme = !isDarkTheme }
                        )
                    }
                    composable("add") {
                        AddEditNoteScreen(
                            navController = navController,
                            noteId = null,
                            viewModel = viewModel,
                            onAdd = { viewModel.addNote(it) },
                            onEdit = {},
                            isDarkTheme = isDarkTheme
                        )
                    }
                    composable(
                        "edit/{noteId}",
                        arguments = listOf(navArgument("noteId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val noteId = backStackEntry.arguments?.getInt("noteId")
                        AddEditNoteScreen(
                            navController = navController,
                            noteId = noteId,
                            viewModel = viewModel,
                            onAdd = {},
                            onEdit = { viewModel.updateNote(it) },
                            isDarkTheme = isDarkTheme
                        )
                    }
                }
            }
        }
    }
}
