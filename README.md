# HiltWork

This is a simple demo application demonstrating the usage of **Hilt** for dependency injection in an Android app following the **MVVM (Model-View-ViewModel)** architecture. The app fetches news articles and displays their titles in a list.

## Features

- **Dependency Injection with Hilt**: Utilizes Hilt for managing dependencies, enhancing testability and modularization.
- **MVVM Architecture**: Follows the MVVM architecture pattern to separate the UI and business logic.
- **Networking Example**: Implements a simple API call to fetch news articles and display them in a LazyColumn.

## Reference
You can download or view the demo video [here](https://github.com/kiran-mercari/HiltDemo/blob/main/HiltWork_demo.webm).


## Architecture

The project follows the following architecture:

- **Model**: Represents the data and handles the data logic. The model fetches news articles from a remote source (e.g., a REST API).
- **View**: The UI components that display the data to the user. This includes activities/fragments that the user interacts with.
- **ViewModel**: Acts as a bridge between the UI (View) and the data (Model). It fetches data from the model and prepares it for the view, maintaining the UI-related data in a lifecycle-conscious way.

## Getting Started

### Prerequisites

- Android Studio Koala+
- Basic understanding of Android Development
- Basic understanding of Dependency Injection, Hilt, and MVVM architecture
