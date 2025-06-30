# 📚 Code Smells and Refactoring Assignment

## 🌟 Overview

This project demonstrates code smells identification and refactoring techniques through a Library Management System implementation. It includes both original code with intentional code smells and a completely refactored version.

## 📁 Project Structure

```
src/main/java/org/qiu/refactoring/
├── Software_construction.java      # 🔴 Original code with code smells
├── Book.java                      # 📖 Original Book entity
├── Member.java                    # 👤 Original Member entity
├── RefactoredMain.java           # 🎯 Main class for refactored version
├── PerformanceComparison.java    # ⚡ Performance comparison tool
└── refactored/                   # ✨ Refactored code package
    ├── Constants.java            # 🔢 Centralized constants
    ├── ValidationUtils.java      # ✅ Common validation utilities
    ├── Book.java                 # 📚 Enhanced Book entity
    ├── Member.java               # 👥 Enhanced Member entity
    ├── BookService.java          # 📖 Book management service
    ├── MemberService.java        # 👤 Member management service
    ├── BorrowingService.java     # 🔄 Borrowing operations service
    └── RefactoredLibraryManager.java # 🎛️ Main orchestrator
```

## 🚀 How to Run

### 📋 Prerequisites

- ☕ Java 21 or higher
- 💻 Command line access

### 🔨 Compilation

```bash
# Compile all Java files
javac -d target/classes src/main/java/org/qiu/refactoring/*.java src/main/java/org/qiu/refactoring/refactored/*.java
```

### ▶️ Running the Applications

#### 1. 🔴 Original Code (with code smells)

```bash
java -cp target/classes org.qiu.refactoring.Software_construction
```

#### 2. ✨ Refactored Code (clean version)

```bash
java -cp target/classes org.qiu.refactoring.RefactoredMain
```

#### 3. ⚡ Performance Comparison (BONUS)

```bash
java -cp target/classes org.qiu.refactoring.PerformanceComparison
```

## 📝 Assignment Requirements Fulfilled

### ✅ Part B: Code Smells and Refactoring (5%)

1. **✅ Existing Software Code**: 📚 Library Management System with intentional code smells
2. **✅ Two Code Smells Identified**:
   - 🐘 God Class (Large Class)
   - 📏 Long Method
   - 🔄 Duplicate Code
   - 🎩 Magic Numbers
   - 🏷️ Poor Naming
3. **✅ Code Smell Detection Methods**: 🔍 Documented tools and techniques
4. **✅ Refactoring Methods**: 🛠️ Comprehensive explanation of refactoring techniques
5. **✅ Fixed and Refactored Code**: ✨ Complete working refactored system
6. **✅ BONUS: Performance Comparison**: 🚀 70.6% performance improvement demonstrated

## 🦨 Key Code Smells Demonstrated

### 1. 🐘 God Class

- **📍 Location**: `LibraryManager` class (211 lines)
- **❌ Problem**: Single class handling multiple responsibilities
- **✅ Solution**: Split into 7 focused service classes

### 2. 📏 Long Method

- **📍 Location**: `addBook()`, `addMember()`, `borrowBook()` methods
- **❌ Problem**: Methods doing too many things
- **✅ Solution**: Extract smaller, focused methods

### 3. 🔄 Duplicate Code

- **📍 Location**: Validation logic repeated across methods
- **❌ Problem**: Same validation patterns in multiple places
- **✅ Solution**: Centralized validation in `ValidationUtils`

### 4. 🎩 Magic Numbers

- **📍 Location**: Hard-coded values like `1900`, `2024`, `5`
- **❌ Problem**: Unclear meaning and maintenance issues
- **✅ Solution**: Named constants in `Constants` class

## 📊 Performance Results

| 📈 Metric                  | 🔴 Original | ✨ Refactored | 🚀 Improvement     |
| ----------------------- | -------- | ---------- | --------------- |
| ⏱️ Execution Time          | 6.12 ms  | 1.80 ms    | 70.6% faster    |
| 💾 Memory Usage            | 1,024 KB | 785 KB     | 23.28% less     |
| 📝 Code Lines (main class) | 211      | 85         | 59.7% reduction |


## 👨‍💻 Authors
- Papula Fouad Ahmed
- Sahand Nasr Mohammed
- Elaf Chatin Khalid
- Meer Hoshyar Ahmed
