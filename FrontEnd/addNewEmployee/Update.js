document.getElementById("employeeForm").addEventListener("submit", async function (event) {
    event.preventDefault(); // Prevent default form submission

    // Collect form data
    const employeeData = {
        employeeId: document.getElementById("employeeId").value,
        name: document.getElementById("name").value,
        department: document.getElementById("department").value,
        employeeSal: document.getElementById("employeeSal").value
    };

    try {
        let response = await fetch("http://localhost:8080/employees/addNewEmployee", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(employeeData)
        });

        if (!response.ok) {
            throw new Error("Error adding employee");
        }

        let data = await response.json();
        alert("Employee added successfully: " + data.employeeId);

        // Reset form after successful submission
        document.getElementById("employeeForm").reset();
    } catch (error) {
        console.error("Error:", error);
        alert("Error adding employee. Please try again.");
    }
});
