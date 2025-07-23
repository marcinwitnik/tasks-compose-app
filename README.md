
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

- Odpowiada za inicjalizację interfejsu użytkownika.
- Ustawia `RecyclerView` do wyświetlania zadań.
- Implementuje nawigację do ekranu dodawania nowego zadania.
- Współpracuje z `ViewModel` w celu obserwowania danych LiveData.

</details>

---

<details>
  <summary>📄 <strong><span style="color:#7b8d8e">Task.kt</span></strong> – model danych (kliknij, aby rozwinąć)</summary>

- Klasa `data class Task(...)` reprezentuje pojedyncze zadanie.
- Adnotacje `@Entity`, `@PrimaryKey`, `@ColumnInfo` definiują strukturę tabeli w Room Database.
- Zawiera pola takie jak: `id`, `title`, `isCompleted`.

</details>

---

<details>
  <summary>📄 <strong><span style="color:#9b59b6">TaskDao.kt</span></strong> – interfejs DAO (kliknij, aby rozwinąć)</summary>

- Zawiera metody dostępu do bazy danych:
  - `getAllTasks()`: zwraca listę zadań jako `LiveData<List<Task>>`
  - `insertTask(task: Task)`
  - `deleteTask(task: Task)`
  - `updateTask(task: Task)`

</details>

---

<details>
  <summary>📄 <strong><span style="color:#2ecc71">AppDatabase.kt</span></strong> – konfiguracja bazy danych (kliknij, aby rozwinąć)</summary>

- Tworzy instancję Room Database.
- Singletonowy dostęp do bazy danych (`getDatabase()`).
- Łączy `TaskDao` i `Task` jako encję.

</details>

---

<details>
  <summary>📄 <strong><span style="color:#e67e22">TaskViewModel.kt</span></strong> – logika widoku (kliknij, aby rozwinąć)</summary>

- Klasa `ViewModel` łącząca warstwę danych z interfejsem UI.
- Wystawia `LiveData<List<Task>>` do obserwacji przez UI.
- Zawiera metody: `addTask()`, `removeTask()`, `toggleCompleted()`.

</details>

---

<details>
  <summary>📄 <strong><span style="color:#c0392b">AddTaskActivity.kt</span></strong> – dodawanie zadań (kliknij, aby rozwinąć)</summary>

- Aktywność z formularzem dodawania nowego zadania.
- Obsługuje przycisk zatwierdzający dodanie do bazy.
- Waliduje dane wejściowe użytkownika.

</details>

</details>

---

<details>
  <summary><img src="https://img.icons8.com/ios-filled/50/FFFFFF/camera.png" height="22px"/> Podgląd działania (kliknij, aby rozwinąć)</summary>

Poniżej przykładowe wyniki działania aplikacji:

![Podgląd działania](images/foto1.png)  
![Podgląd działania](images/foto2.png)  
![Podgląd działania](images/foto3.png)  
![Podgląd działania](images/foto4.png)  
![Podgląd działania](images/foto5.png)  

</details>
