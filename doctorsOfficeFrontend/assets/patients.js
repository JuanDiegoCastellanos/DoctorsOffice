function loadData(){
    let request = sendRequest('patient/list', 'GET', '');
    let table = document.getElementById('patientsTable');
    table.innerHTML = "";
    request.onload = function(){

        let data = request.response;
        data.forEach((element,index) => {
            table.innerHTML += `
            <tr>
                <td class='text-center'>${element.patientName} ${element.patientLastname}</td>
                <td class='text-center'>${element.patientAge}</td>
                <td class='text-center'>${
                    element.patientGender == 1 ? 'Femenino': element.patientGender == 2 ? 'Masculino':'NN'
                }</td>
                <td class='text-center'>${element.patientDocumentType} ${element.patientDocument}</td>
                <td class='text-center'>${element.patientPhoneNumber}</td>
                <td class='text-center'>${element.patientEps}</td>
                <td class='text-center' >
                    <a href="../patients/create.html?id=${element.patientId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deletePatient(${element.patientId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
                </td>
            </tr>
            `   
        }
        );
        request.onerror = function(){
            table.innerHTML = `
            <tr>
                <td colspan="6">
                    Error on load the data
                </td>   
            </tr>
            `;
        }
    }
}
function loadPatientByName(){

    let request = sendRequest('patient/list', 'GET', '');
    let divTable = document.getElementById('spaceTable');
    let name = document.getElementById('inputName').value;
    let data;
    request.onload = function () {
        if(name == ''){
            alert('Por favor llena el campo de búsqueda')
        }else{
            data = request.response;
            let patient;
            for (let index = 0; index < data.length; index++) {
                const element = data[index];
                if(element.patientName.trim().toUpperCase() == name.trim().toUpperCase()){
                    patient = element;
                }
            }
            console.log(patient);

            divTable.innerHTML = `
         <table class="table table-dark table-hover table-sm">
            <thead>
                <tr>
                    <th class="text-center" >Full Name</th>
                    <th class="text-center" >Age</th>
                    <th class="text-center" >Gender</th>
                    <th class="text-center" >Document</th>
                    <th class="text-center" >Phone Number</th>
                    <th class="text-center" >Eps</th>
                    <th class="text-center" ></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="" >${patient.patientName + " " + patient.patientLastname}</td>
                    <td class="text-center">${patient.patientAge}</td>
                    <td class="text-center">${
                        patient.patientGender == 1 ? 'Femenino': patient.patientGender == 2 ? 'Masculino':'NN'
                    }</td>
                    <td class="text-center">${patient.patientDocument}</td>
                    <td class="text-center">${patient.patientDocumentType}</td>
                    <td class="text-center">${patient.patientEps}</td>
                    <td class="text-center">
                    <a href="../patients/create.html?id=${patient.patientId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deletePatient(${patient.patientId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
                    </td>
                 </tr>                    
            </tbody>
         </table>
         `;
        }
        
    } 
}



function loadPatient(idPatient) {
    let request = sendRequest('patient/list/'+idPatient, 'GET', '');
    let id = document.getElementById('inputId');
    let name = document.getElementById('inputName');
    let lastName = document.getElementById('inputLastName');
    let age = document.getElementById('inputAge');
    let eps = document.getElementById('inputEps');
    let documentField = document.getElementById('inputDocument');
    let documentType = document.getElementById('inputDocumentType');
    let phoneNumber = document.getElementById('inputPhone');
    let gender = document.getElementById('selectGender');
    
    request.onload = function () {
        let data = request.response;
        id.value = data.patientId;
        name.value = data.patientName;
        lastName.value = data.patientLastname;
        age.value = data.patientAge;
        eps.value = data.patientEps;
        documentField.value = data.patientDocument;
        documentType.value = data.patientDocumentType;
        phoneNumber.value = data.patientPhoneNumber;
        gender.value = data.patientGender;

    }
    request.onerror = function(){
        alert("Error al recuperar los datos");
    }
}

function deletePatient(idPatient){
    let request =  sendRequest('patient/'+idPatient, 'DELETE','');
    request.onload = function () {
        loadData();
    }
}

function savePatient(){
    //let id = document.getElementById('inputId').value;
    // Como es autoincrement el campo en bd, no hay necesidad de que se ingrese
    let name = document.getElementById('inputName').value
    let lastName = document.getElementById('inputLastName').value
    let age = document.getElementById('inputAge').value
    let eps = document.getElementById('inputEps').value
    let documentField = document.getElementById('inputDocument').value
    let documentType = document.getElementById('inputDocumentType').value
    let phoneNumber = document.getElementById('inputPhone').value
    let gender = document.getElementById('selectGender').value

    let data = {
        "patientName":name,
        "patientLastname":lastName,
        "patientAge":age,
        "patientGender":gender,
        "patientDocument":documentField,
        "patientDocumentType":documentType,
        "patientPhoneNumber":phoneNumber,
        "patientEps":eps
    }

    let request = sendRequest('patient/','POST', data)

    request.onload = function(){
        window.location = '../patients/index.html';
    }
    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}

function editPatient() {
    let id = document.getElementById('inputId').value
    let name = document.getElementById('inputName').value
    let lastName = document.getElementById('inputLastName').value
    let age = document.getElementById('inputAge').value
    let eps = document.getElementById('inputEps').value
    let documentField = document.getElementById('inputDocument').value
    let documentType = document.getElementById('inputDocumentType').value
    let phoneNumber = document.getElementById('inputPhone').value
    let gender = document.getElementById('selectGender').value

    let data = {
        "patientId":id,
        "patientName":name,
        "patientLastname":lastName,
        "patientAge":age,
        "patientGender":gender,
        "patientDocument":documentField,
        "patientDocumentType":documentType,
        "patientPhoneNumber":phoneNumber,
        "patientEps":eps
    }

    let request = sendRequest('patient/',id ? 'PUT':'POST', data)

    request.onload = function(){
        window.location = '../patients/index.html';
    }

    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}