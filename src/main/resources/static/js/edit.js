document.addEventListener("DOMContentLoaded", function () {
    // Hide the loading spinner when the page is loaded
    hideLoadingSpinner();

    // Event listener for form submission
    document.getElementById("searchForm").addEventListener("submit", function (event) {
        // Prevent the default form submission
        event.preventDefault();
        // Trigger the searchUser function when the form is submitted
        searchUser();
    });

    // Event listener for the "Clear" button
    document.getElementById("clearButton").addEventListener("click", function () {
        // Clear search results and input field
        clearResults();
    });
});

// Function to make the search request and handle results
async function searchUser() {
    try {
        const displayname_th = document.getElementById("displayname_th").value;

        // Display loading spinner during the search
        showLoadingSpinner();

        const response = await fetch(`/edit/users/findByDisplayNameTh/${displayname_th}`);
        const data = await response.json();

        // Display search results
        displayResults(data);
    } catch (error) {
        console.error('Error:', error);
        // Handle errors gracefully
        displayError('An error occurred during the search.');
    } finally {
        // Hide the loading spinner
        hideLoadingSpinner();
    }
}

// Function to clear search results and input field
function clearResults() {
    // Clear search results
    document.getElementById("searchResults").innerHTML = "";
    // Clear the input field
    document.getElementById("displayname_th").value = "";
}

// Function to display loading spinner
function showLoadingSpinner() {
    document.getElementById("loadingSpinner").style.display = "block";
}

// Function to hide loading spinner
function hideLoadingSpinner() {
    document.getElementById("loadingSpinner").style.display = "none";
}

// Function to display search results
function displayResults(users) {
    const resultsDiv = document.getElementById("searchResults");
    resultsDiv.innerHTML = "";

    if (users.length > 0) {
        const resultList = document.createElement("ul");

        users.forEach(user => {
            const listItem = document.createElement("li");
            listItem.textContent = `Username: ${user.username}, Email: ${user.email}`;
            resultList.appendChild(listItem);
        });

        resultsDiv.appendChild(resultList);
    } else {
        resultsDiv.textContent = "No users found.";
    }
}

// Function to display error message
function displayError(message) {
    const resultsDiv = document.getElementById("searchResults");
    resultsDiv.innerHTML = `<p class="error-message">${message}</p>`;
}
