"use strict";


/**
 * 
 * @param {String} dateToRequest 
 * @returns 
 */
async function getProcurements(dateToRequestFrom,dateToRequestTo) {
    const response = await fetch(`http://127.0.0.1:8080/procurement/${dateToRequestFrom}-${dateToRequestTo}`);
    if (!response.ok) {
        console.log(
            "Network request for products.json failed with response " +
            response.status +
            ": " +
            response.statusText,
        );
        throw new Error(`Did not manage to get data from Server`);
    }

    const result = await response.json();
    return result;
}
const procurementsBoxElement = document.querySelector('.procurements_box');
const procurementsBoxElementVariable = document.createElement('div');
procurementsBoxElement.insertAdjacentElement("beforeend", procurementsBoxElementVariable);

document.addEventListener('DOMContentLoaded', async () => {
    const procurements = await getProcurements(dateToRequestFrom,dateToRequestTo);
    procurements.forEach(procurement => {
        const procurementElement = document.createElement('div');
        procurementsBoxElementVariable.insertAdjacentElement("beforeend", procurementElement);
        for (let key in procurement) {
            const procurementPropertyElement = document.createElement('p');
            procurementPropertyElement.textContent = procurement[key];
            procurementsBoxElementVariable.insertAdjacentElement("beforeend", procurementPropertyElement);
        }
    })
});