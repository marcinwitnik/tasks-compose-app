package com.example.taskscompose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskscompose.model.Note
import com.example.taskscompose.viewmodel.NoteViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AddEditNoteScreen(
    navController: NavController,
    noteId: Int?,
    viewModel: NoteViewModel,
    onAdd: (Note) -> Unit,
    onEdit: (Note) -> Unit,
    isDarkTheme: Boolean
) {
    val currentNote by viewModel.currentNote.collectAsState()

    var titleState by remember { mutableStateOf(TextFieldValue("")) }
    var contentState by remember { mutableStateOf(TextFieldValue("")) }

    LaunchedEffect(noteId) {
        if (noteId != null) {
            viewModel.loadNote(noteId)
        } else {
            viewModel.clearCurrentNote()
        }
    }

    LaunchedEffect(currentNote) {
        currentNote?.let {
            titleState = TextFieldValue(it.title)
            contentState = TextFieldValue(it.content)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = if (noteId == null) "Nowa Notatka" else "Edytuj Notatkę")
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            OutlinedTextField(
                value = titleState,
                onValueChange = { titleState = it },
                label = { Text("Tytuł") },
                placeholder = { Text("Wpisz tytuł") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = contentState,
                onValueChange = { contentState = it },
                label = { Text("Treść") },
                placeholder = { Text("Wpisz tekst") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                singleLine = false
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Button(onClick = {
                    val note = Note(
                        id = noteId ?: 0,
                        title = titleState.text,
                        content = contentState.text
                    )
                    if (noteId == null) {
                        onAdd(note)
                    } else {
                        onEdit(note)
                    }
                    navController.popBackStack()
                }) {
                    Text("Zapisz")
                }

                Spacer(modifier = Modifier.width(12.dp))

                OutlinedButton(onClick = {
                    navController.popBackStack()
                }) {
                    Text("Anuluj")
                }
            }
        }
    }
}
