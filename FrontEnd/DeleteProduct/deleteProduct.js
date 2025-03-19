document.getElementById("productForm").addEventListener("submit", async function (event) 
{
    event.preventDefault(); // Prevent form submission

    const productId = document.getElementById("productId").value.trim();

    if (!productId) 
    {
        alert("Please enter an product ID.");
        return;
    }

    try 
    {
        let response = await fetch(`http://localhost:8080/products/deleteProductById/${productId}`,
         {
            method: "DELETE", 
            headers: 
            {
                "Content-Type": "application/json"
            }
        });

        if (!response.ok) 
        {
            throw new Error("Error deleting product");
        }

        alert("Product deleted successfully!");

        document.getElementById("productForm").reset();
    } 
    catch (error) 
    {
        console.error("Error:", error);
        alert("Error deleting product. Please try again.");
    }
});
