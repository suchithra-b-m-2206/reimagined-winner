# Complex Python program: A basic calculator

def add(x, y):
    """Function to add two numbers"""
    return x + y

def subtract(x, y):
    """Function to subtract two numbers"""
    return x - y

def multiply(x, y):
    """Function to multiply two numbers"""
    return x * y

def divide(x, y):
    """Function to divide two numbers"""
    if y == 0:
        return "Error! Division by zero."
    return x / y

def exponentiate(x, y):
    """Function to calculate the exponentiation of two numbers"""
    return x ** y

def calculator():
    """Function to perform the calculator operations"""
    print("Welcome to the Python Calculator!")
    print("Select an operation:")
    print("1. Addition (+)")
    print("2. Subtraction (-)")
    print("3. Multiplication (*)")
    print("4. Division (/)")
    print("5. Exponentiation (^)")

    while True:
        # Get user input
        choice = input("\nEnter choice (1/2/3/4/5) or 'q' to quit: ")

        # Check if user wants to exit the calculator
        if choice.lower() == 'q':
            print("Exiting the calculator. Goodbye!")
            break

        # Check if the choice is one of the available options
        if choice in ['1', '2', '3', '4', '5']:
            try:
                num1 = float(input("Enter the first number: "))
                num2 = float(input("Enter the second number: "))
            except ValueError:
                print("Invalid input! Please enter a valid number.")
                continue

            if choice == '1':
                print(f"The result is: {add(num1, num2)}")
            elif choice == '2':
                print(f"The result is: {subtract(num1, num2)}")
            elif choice == '3':
                print(f"The result is: {multiply(num1, num2)}")
            elif choice == '4':
                print(f"The result is: {divide(num1, num2)}")
            elif choice == '5':
                print(f"The result is: {exponentiate(num1, num2)}")
        else:
            print("Invalid choice! Please select a valid operation.")

# Run the calculator function
calculator()
