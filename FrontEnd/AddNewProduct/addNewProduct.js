document.getElementById("productForm").addEventListener("submit", async function (event) {
    event.preventDefault(); 

    const productData = 
    {
        productId: document.getElementById("productId").value,
        productName: document.getElementById("productName").value,
        productPrice: document.getElementById("productPrice").value,
        productQuantity: document.getElementById("productQuantity").value
    };

    try 
    {
        let response = await fetch("http://localhost:8080/products/addNewProduct", 
        {
            method: "POST",
            headers: 
            {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(productData)
        });

        if (!response.ok) 
        {
            throw new Error("Error adding employee");
        }

        let data = await response.json();
        alert("Product added successfully: " + data.productData);

        // Reset form after successful submission
        document.getElementById("productForm").reset();
    } 
    catch (error) 
    {
        console.error("Error:", error);
        alert("Error adding product. Please try again.");
    }
});
