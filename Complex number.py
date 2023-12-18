def complex_operations():
    # Get user input for complex numbers
    real1 = float(input("Enter the real part of the first complex number: "))
    imag1 = float(input("Enter the imaginary part of the first complex number: "))
    real2 = float(input("Enter the real part of the second complex number: "))
    imag2 = float(input("Enter the imaginary part of the second complex number: "))

    # Create complex numbers
    complex_num1 = complex(real1, imag1)
    complex_num2 = complex(real2, imag2)

    # Perform arithmetic operations
    sum_result = complex_num1 + complex_num2
    difference_result = complex_num1 - complex_num2
    product_result = complex_num1 * complex_num2
    quotient_result = complex_num1 / complex_num2

    # Display the results
    print(f"Sum: {sum_result}")
    print(f"Difference: {difference_result}")
    print(f"Product: {product_result}")
    print(f"Quotient: {quotient_result}")

# Run the program
complex_operations()
