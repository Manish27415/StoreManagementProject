document.getElementById("employeeForm").addEventListener("submit", async function (event) {
    event.preventDefault(); // Prevent form submission

    const employeeId = document.getElementById("employeeId").value.trim();

    if (!employeeId) 
    {
        alert("Please enter an Employee ID.");
        return;
    }

    try 
    {
        let response = await fetch(`http://localhost:8080/employees/deleteEmployeeById/${employeeId}`,
         {
            method: "DELETE", 
            headers: 
            {
                "Content-Type": "application/json"
            }
        });

        if (!response.ok) 
        {
            throw new Error("Error deleting employee");
        }

        alert("Employee deleted successfully!");

        document.getElementById("employeeForm").reset();
    } 
    catch (error) 
    {
        console.error("Error:", error);
        alert("Error deleting employee. Please try again.");
    }
});
