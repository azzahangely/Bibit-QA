# 📱🧪 QA Automation Test Suite

This repository contains automated test scripts for **Web UI**, **API**, and **Android Mobile** platforms, built using Java, Cucumber, and Appium.

---

## 📁 Project Structure

| Task | Scope            | Tools                         | Status     |
|------|------------------|-------------------------------|------------|
| 1    | Web UI Automation| Java, Selenium, Cucumber      | ✅ Completed |
| 2    | API Test         | Java, RestAssured, Cucumber   | ✅ Completed |
| 3    | API Test         | Java, RestAssured, Cucumber   | ✅ Completed |
| 4    | API Test         | Java, RestAssured, Cucumber   | ✅ Completed |
| 5    | API Test         | Java, RestAssured, Cucumber   | ✅ Completed |
| 6    | Android UI Test  | Java, Appium, Cucumber        | ✅ Completed |

---

## 🛠 Prerequisites

Ensure the following tools are installed:

- Java 17
- Maven
- IntelliJ IDEA (or any IDE)
- Node.js & npm (required for Appium)
- Android Studio & SDK (if testing on emulator)
- Appium Server (start via CLI or Appium Desktop)

> ⚠️ **Note**: `MobileDriverManager.java` contains `deviceName` hardcoded (`SM_A546E`). Please update it if you are using another device or emulator.

Install dependencies via Maven:

```bash
mvn clean install
```

---

## 🚀 How to Run the Tests

### ✅ 1. Web Tests

```bash
mvn test -Dcucumber.filter.tags="@web"
```
or right-click the test runner class in IntelliJ and select **Run**.

### 🔗 2. API Tests

```bash
mvn test -Dcucumber.filter.tags="@api"
```
or run via IntelliJ.

### 📱 3. Android Mobile Tests

1. Start Appium Server:
    ```bash
    appium
    ```
2. Connect physical device or run emulator.
3. Run test:
    ```bash
    mvn test -Dcucumber.filter.tags="@android"
    ```
or via IntelliJ (e.g., run `AndroidRunner.java`).

---

## 🧩 Tags & Hooks

- Each feature uses tags: `@web`, `@api`, or `@android`.
- `Hooks.java` conditionally starts the relevant driver based on tag.
- MobileDriver will only initialize when `@android` is present.

---

## 🔁 Helper & Reusable Code

### ✅ Utilities:

- `DriverManager.java`: WebDriver manager for Web tests.
- `WebActions.java`: Utility for custom Selenium interactions.
- `MobileDriverManager.java`: AndroidDriver management.
- `MobileActions.java`: Reusable functions like dynamic scroll.
- `Hooks.java`: Tag-based conditional setup and teardown.

### 🧪 Step Definitions:

- `WebSteps.java`: Web interaction steps.
- `ApiSteps.java`: API validation with RestAssured.
- `MobileSteps.java`: Mobile automation steps (click, input, scroll, etc).

---

## 📂 Feature File Structure

```
src
├── test
│   ├── java
│   │   ├── stepDefinitions/
│   │   ├── utils/
│   └── resources
│       └── features/
│           ├── api/
│           ├── mobile/
│           └── web/
```

---

## 📌 Sample Feature Tags

```gherkin
@android
Feature: Android purchase test

  Scenario: User can login and purchase product
    Given the user opens the app
    When the user clicks element with accessibility id "View menu"
    ...
```

---

## ✅ Test Result

All scenarios pass under the right configuration. Make sure device/emulator is ready and Appium is running before executing `@android` tests.

💡 Please find the uploaded video for testing documentation in [this link](https://drive.google.com/drive/folders/1U2hubs6STs9rwpvOyU7q1VGZd3i3J8sX?usp=sharing).

---

---

📌 Maintained and Developed by: **Azzah Azkiyah**

📧 Contact: azzah.azkiyah@ui.ac.id  
🔗 GitHub: [@azzahangely](https://github.com/azzahangely)

