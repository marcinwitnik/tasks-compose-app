
<h1 align="center"><img src="https://img.icons8.com/ios-filled/50/FFFFFF/android.png" height="22px" /> Aplikacja Mobilna: Lista Zadań w Kotlin</h1>

Ten projekt to **prosta i funkcjonalna aplikacja mobilna do zarządzania listą zadań (TODO)**, stworzona w języku Kotlin z wykorzystaniem Android Studio. Pozwala użytkownikowi na dodawanie, usuwanie i oznaczanie zadań jako wykonane. Dane przechowywane są lokalnie za pomocą **Room Database**. Aplikacja została stworzona z wykorzystaniem wzorca architektonicznego **MVVM**, co zapewnia przejrzystość i łatwość w rozbudowie projektu.

---

## <img src="https://img.icons8.com/pastel-glyph/64/FFFFFF/code--v2.png" height="22px" /> Technologie i środowisko

- **Język:** Kotlin
- **Środowisko IDE:** Android Studio  
- **Running devices:** samsung SM-A346B •  
- **Biblioteki:**
  - Room – lokalna baza danych do przechowywania zadań
  - LiveData – obserwowalność zmian danych
  - ViewModel – logika biznesowa oddzielona od widoku
  - RecyclerView – efektywne renderowanie listy zadań
  - Material Components – stylizacja aplikacji
  - Navigation Component – zarządzanie nawigacją między ekranami

---

<details>
  <summary><img src="https://img.icons8.com/ios-filled/50/FFFFFF/pin.png" height="22px"/> Funkcje programu (kliknij, aby rozwinąć)</summary>

---

<details>
  <summary>📄 <strong><span style="color:#4a90e2">MainActivity.kt</span></strong> – główna aktywność (kliknij, aby rozwinąć)</summary>

- Inicjalizuje całą aplikację Compose.
- Ustawia motyw (jasny/ciemny) z możliwością przełączania.
- Obsługuje nawigację pomiędzy ekranami listy i edycji notatek.
- Inicjalizuje bazę danych i ViewModel z repozytorium.
- Przykładowo usuwa wszystkie notatki przy starcie (do testów).

</details>

---

<details>
  <summary>📄 <strong><span style="color:#7b8d8e">Note.kt</span></strong> – model danych (kliknij, aby rozwinąć)</summary>

- Klasa danych reprezentująca notatkę.
- Oznaczona jako `@Entity` dla Room Database.
- Pola: `id`, `title`, `content`.

</details>

---

<details>
  <summary>📄 <strong><span style="color:#9b59b6">NoteDao.kt</span></strong> – interfejs DAO (kliknij, aby rozwinąć)</summary>

- Udostępnia operacje na bazie danych:
  - `getAllNotes()`: zwraca wszystkie notatki jako `Flow<List<Note>>`
  - `getNoteById(id)`: pobiera notatkę po ID
  - `addNote(note)`: dodaje lub aktualizuje notatkę
  - `deleteNote(note)`: usuwa notatkę
  - `deleteAllNotes()`: usuwa wszystkie notatki

</details>

---

<details>
  <summary>📄 <strong><span style="color:#2ecc71">NoteDatabase.kt</span></strong> – konfiguracja bazy danych (kliknij, aby rozwinąć)</summary>

- Tworzy bazę danych Room z encją `Note` i DAO `NoteDao`.
- Zawiera mechanizm singletonowy dla jednej instancji bazy.

</details>

---

<details>
  <summary>📄 <strong><span style="color:#f39c12">NoteRepository.kt</span></strong> – warstwa pośrednia (kliknij, aby rozwinąć)</summary>

- Oddziela logikę bazodanową od ViewModelu.
- Udostępnia metody `addNote`, `getNoteById`, `deleteNote`, `deleteAllNotes`.
- `notes`: przepływ wszystkich notatek jako `Flow<List<Note>>`.

</details>

---

<details>
  <summary>📄 <strong><span style="color:#e67e22">NoteViewModel.kt</span></strong> – logika widoku (kliknij, aby rozwinąć)</summary>

- Łączy repozytorium z interfejsem UI.
- Przechowuje i aktualizuje listę notatek oraz notatkę aktualnie edytowaną.
- Udostępnia metody: `addNote`, `updateNote`, `deleteNote`, `loadNote`, `clearCurrentNote`.

</details>

---

<details>
  <summary>📄 <strong><span style="color:#3498db">AddEditNoteScreen.kt</span></strong> – ekran dodawania/edycji notatki (kliknij, aby rozwinąć)</summary>

- Dynamiczny ekran służący do dodawania lub edytowania notatki.
- Obsługuje wprowadzenie tytułu i treści notatki.
- Używa ViewModelu do załadowania notatki i zapisania zmian.
- Zawiera przyciski: „Zapisz” i „Anuluj”.

</details>

---

<details>
  <summary>📄 <strong><span style="color:#1abc9c">NoteListScreen.kt</span></strong> – ekran listy notatek (kliknij, aby rozwinąć)</summary>

- Wyświetla listę wszystkich notatek.
- Umożliwia przejście do ekranu edycji po kliknięciu na notatkę.
- Zawiera przycisk do przełączenia motywu (jasny/ciemny).
- Posiada `FloatingActionButton` do dodawania nowych notatek.

</details>

---

<details>
  <summary>📄 <strong><span style="color:#8e44ad">NoteCard.kt</span></strong> – komponent UI notatki (kliknij, aby rozwinąć)</summary>

- Komponent wyświetlający pojedynczą notatkę w formie karty.
- Umożliwia kliknięcie i przejście do edycji notatki.
- Styl oparty na Material3 z tytułem i treścią.

</details>

</details>

---

<details>
  <summary><img src="https://img.icons8.com/ios-filled/50/FFFFFF/camera.png" height="22px"/> Podgląd działania (kliknij, aby rozwinąć)</summary>

Poniżej przykładowe wyniki działania aplikacji:

![Podgląd działania](foto1.jpg)  
![Podgląd działania](foto2.jpg)  
![Podgląd działania](foto3.jpg)  
![Podgląd działania](foto4.jpg)  
![Podgląd działania](foto5.jpg)  

</details>
