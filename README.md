# WisebitsTestTask
## To automate the following test case:
1. Open the page
2. Fill in the fields username, email, and password with any valid data
3. Click on Start earning money
4. Choose Business account type, fill in mandatory fields, and click on Next
5. On the second step "Agreement": Check that step 2 is active in the header;
   agree with conditions, click on the checkbox, and click on Next
6. On the third step "Verification": Check that step 2 is active in the header;
   upload documents for mandatory fields and click on Finish
   Registration.
7. Modal window appears, where you need to choose all points and
   fill in mandatory fields, and click on submit.
8. Check the existence of the header "Complete registration" and
   in the message, there is the same email as in the registration step.

- Parallel run of tests, cross-browser testing
- Existence of Allure report
- Ready test task push on GitHub
  Test tasks must be done on Java (8+) and using the framework Selenide.

We use Java 16, Selenide, Junit, Gradle, and Allure. Don't use BDD frameworks.

## Realization
Java 11, Selenide, Junit5, Gradle, Allure, WebDriverManager

## Comments
It was my first experience using Selenide, not canonical structure, but it was my decision.

Separately realized parallel run and separately cross-browser testing.