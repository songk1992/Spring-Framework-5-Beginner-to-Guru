

document.addEventListener('readystatechange', event => {
    if (event.target.readyState === "interactive") {   // ..addEventListener("DOMContentLoaded"..

    }

    // When window loaded ( // external resources are loaded too- `css`,`src`, etc...)
    if (event.target.readyState === "complete") {
        typeFn();
    }
});



const typeFn = async ()=> {
    const sentence = document.getElementById("joke-text");
    const letters = sentence.innerText.split("").reverse();
    let outputLetters = "";
    sentence.innerText = "";

    let i = 0;
    while (letters.length > 0){
        await waitForMs(150);
        outputLetters += letters.pop();
        sentence.innerText = outputLetters;
    }
}

function waitForMs(ms) {
    return new Promise(resolve => setTimeout(resolve, ms))
}