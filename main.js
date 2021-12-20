const apiUrl = 'localhost:8080/candidates/';
fetch(apiUrl)
    .then(response => response.json())
    .then(candidateData => {
        console.log(candidateData);
    })
    .catch((error) => {
        console.log(error);
    });
