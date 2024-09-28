function checkEnter(event) {
    if (event.key === "Enter") {
        fetchData();
    }
}   

function fetchData() {
const state = document.getElementById('stateInput').value;
console.log(state);  // Check if the state is correct here
const resultDiv = document.getElementById('result');
const loadingDiv = document.querySelector('.loading');

if (!state) {
    alert('Please enter a state name');
    return;
}

resultDiv.classList.remove('show');
loadingDiv.style.display = 'block';

fetch(`http://localhost:8080/covid-data/citywise/${state}`)
    .then((response) => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(( data) => {
        loadingDiv.style.display = 'none';
        if (data == "") {
            throw new Error('No data found for the selected state.');
        }
        console.log(data);
        showData(data,resultDiv,state);
        resultDiv.classList.add('show');
    })
    .catch(error => {
        loadingDiv.style.display = 'none';
        resultDiv.innerHTML = `<p>Error: ${error.message}</p>`;
        resultDiv.classList.add('show');
    });
} 


function showData(data,resultDiv,state) { 
console.log( typeof data);

arr = data.split(",");
console.log(arr);

resultDiv.innerHTML = `
    <h2>${state.toUpperCase()}</h2>
    <p>Confirmed cases: ${arr[0]}</p>
    <p>Recovered: ${arr[1]}</p>
    <p>Deaths: ${arr[2]}</p>
    <p>Last updated: 2021-07-23T18:18:37.732Z</p>
`;
}
