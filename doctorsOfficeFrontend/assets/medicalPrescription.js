function loadData(){
    let request = sendRequest('medicalprescription/list', 'GET', '');
    let table = document.getElementById('medicalPrescriptionsTable');
    table.innerHTML = " ";
    request.onload = function(){

        let data = request.response;
        data.forEach((element) => {
            table.innerHTML += `
            <tr>
                <td class='text-center'>${element.date}</td>
                <td class='text-center'>${element.amountMedicines}
                <a href="../medical_prescriptions/addMedicine.html?id=${element.medicalprescriptionId}">
                <i class="bi bi-pencil-square" style="color: yellowgreen;"></i>
                </a>                
                </td>
                <td class='text-center'>${element.patient.patientName}</td>
                <td class='text-center'>${element.doctor.doctorName}</td>
                <td class='text-center'>
                    <a href="../medical_prescriptions/create.html?id=${element.medicalprescriptionId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deleteMedicalPrescription(${element.medicalprescriptionId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
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
function loadDoctors(){
    let request = sendRequest('doctor/list', 'GET', '');
    let selectDoctor = document.getElementById('selectDoctor');
    selectDoctor.innerHTML = "";
    request.onload = function(){

        let data = request.response;

        data.forEach(element => {
            selectDoctor.innerHTML += `
             <option value="${element.doctorId}">${element.doctorName}</option>
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
function loadPatients(){
    let request = sendRequest('patient/list', 'GET', '');
    let selectPatient = document.getElementById('selectPatient');
    selectPatient.innerHTML = "";
    request.onload = function(){

        let data = request.response;

        data.forEach(element => {
            selectPatient.innerHTML += `
             <option value="${element.patientId}">${element.patientName}</option>
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
function loadMedicalPrescription(idMedicalPrescription) {
    let request = sendRequest('medicalprescription/list/'+idMedicalPrescription, 'GET', '');
    let id = document.getElementById('inputId');
    let date = document.getElementById('inputDate');
    let amountMedicinesPres = document.getElementById('inputCantidadMedicamentos');
    let doctor = document.getElementById('selectDoctor');
    let patient = document.getElementById('selectPatient');

    
    request.onload = function () {
        let data = request.response;
        id.value = data.medicalprescriptionId;
        amountMedicinesPres.value = data.amountMedicines;
        date.value = data.date;
        doctor.value = data.doctor.doctorId;
        patient.value = data.patient.patientId;
    }
    request.onerror = function(){
        alert("Error al recuperar los datos");
    }
}

function deleteMedicalPrescription(idMedicalPrescription){
    let request =  sendRequest('medicalprescription/'+idMedicalPrescription, 'DELETE','');
    request.onload = function () {
        loadData();
    }
}

function searchMedicine(){
    let request = sendRequest('medicine/list', 'GET', '');
    let divTable = document.getElementById('spaceTable');
    let name = document.getElementById('inputName').value;
    let data;
    const urlParams = new URLSearchParams(window.location.search);
    let idMediPres = urlParams.get('id')
    request.onload = function () {
        if(name == ''){
            alert('Por favor llena el campo de búsqueda');
        }else{
            data = request.response;
            let medicine;
            for (let index = 0; index < data.length; index++) {
                const element = data[index];
                if(element.medicineName.trim().toUpperCase() == name.trim().toUpperCase()){
                    medicine = element;
                }
            }
            divTable.innerHTML = `
         <table class="table table-dark table-hover table-sm">
            <thead>
                <tr>
                    <th class="text-center" >Medicine Name</th>
                    <th class="text-center" >Laboratory</th>
                    <th class="text-center" >Agregar Medicamentos</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="text-center" >${medicine.medicineName}</td>
                    <td class="text-center">${medicine.laboratory}</td>
                    <td class="text-center">
                    <a href="" onclick="addToPrescription(${medicine.medicineId},${idMediPres})" ><i class="bi bi-plus-circle-fill" style="color:chartreuse;"></i></a>
                    </td>
                 </tr>                    
            </tbody>
         </table>
         `;
        }
        
    }

}

function addToPrescription(medicineId, medicalPresId){

    if(medicalPresId!=null && medicineId != null){
        
        let request = sendRequest('medicalprescription/list/'+medicalPresId, 'GET', '');

        let arrayMedicinesMedi = [];
        let data;
        arrayMedicinesMedi.push(medicineId);
        
        request.onload = function () {
            data = request.response;
            let dataMedicinePres = {
                "medicalPrescription": {
                    "medicalprescriptionId":data.medicalprescriptionId
                },
                "medicine":{
                    "medicineId":medicineId
                }
            }
            console.log(dataMedicinePres);
            let requestCrear = sendRequest('medicineprescription/','POST',dataMedicinePres);
            
            medicalPrescriptionUpdated = {
                "medicalprescriptionId": data.medicalprescriptionId,
                "date":data.date,
                "amountMedicines":data.amountMedicines + arrayMedicinesMedi.length,
                "patient":data.patient,
                "doctor":data.doctor
            }
            console.log(medicalPrescriptionUpdated);
    
            let requestUpdate = sendRequest('medicalprescription/','PUT', medicalPrescriptionUpdated);
            
            console.log(requestUpdate);
            requestUpdate.onerror = function(){
                alert("Error en actualizar la prescripción medica")
            }
            requestCrear.onerror = function(){
                alert("Error en añadir medicamentos a la prescripción médica");
            }
        }        

        request.onerror = function(){
            alert("Error al recuperar los datos de la prescripción médica");
        }
        
    }else{
        alert("Ha ocurrido un error, revise la información");
    }
}

function saveMedicalPrescription(){
    
    let date = document.getElementById('inputDate').value
    let doctor = document.getElementById('selectDoctor').value
    let patient = document.getElementById('selectPatient').value
    let amountMedicinesPres = document.getElementById('inputCantidadMedicamentos').value
    if(amountMedicinesPres=="") amountMedicinesPres = 0;

    let data = {
        "date":date,
        "amountMedicines":amountMedicinesPres,
        "patient":{
            "patientId":patient
        },
        "doctor":{
            "doctorId":doctor
        }
    }
    
    let request = sendRequest('medicalprescription/','POST', data)

    request.onload = function(){
        window.location = '../medical_prescriptions/index.html';
    }
    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}

function editMedicalPrescription() {
    let id = document.getElementById('inputId').value
    let date = document.getElementById('inputDate').value
    let amountMedicinesPres = document.getElementById('inputCantidadMedicamentos').value
    let doctor = document.getElementById('selectDoctor').value
    let patient = document.getElementById('selectPatient').value

    let data = {
        "medicalprescriptionId":id,
        "date":date,
        "amountMedicines":amountMedicinesPres,
        "patient":{
            "patientId":patient
        },
        "doctor":{
            "doctorId":doctor
        }
    }

    let request = sendRequest('medicalprescription/',id ? 'PUT':'POST', data)

    request.onload = function(){
        window.location = '../medical_prescriptions/index.html';
    }

    request.onerror = function(){
        alert("Error al guardar los cambios");
    }
}

function loadMedicalPrescriptionByPatient() {

    let request = sendRequest('medicalprescription/list', 'GET', '');
    let divTable = document.getElementById('spaceTable');
    let name = document.getElementById('inputName').value;
    let data;

    request.onload = function () {
        if(name == ''){
            alert('Por favor llena el campo de búsqueda');
        }else{
            data = request.response;
            let medicalPrescriptions;
            for (let index = 0; index < data.length; index++) {
                const element = data[index];
                if(element.patient.patientName.trim().toUpperCase() == name.trim().toUpperCase()){
                    medicalPrescriptions = element;
                }
            }
            if(medicalPrescriptions != undefined || medicalPrescriptions != null){
            divTable.innerHTML = `
         <table class="table table-dark table-hover table-sm">
            <thead>
                <tr>
                    <th class="text-center">Date</th>
                    <th class="text-center">Amount Medicines</th>
                    <th class="text-center">Patient</th>
                    <th class="text-center">Doctor</th>
                    <th class="text-center"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="">${medicalPrescriptions.date}</td>
                    <td class="text-center">${medicalPrescriptions.amountMedicines}</td>
                    <td class="text-center">${medicalPrescriptions.patient.patientName}</td>
                    <td class="text-center">${medicalPrescriptions.doctor.doctorName}</td>
                    <td class="text-center">
                    <a href="../medicines/create.html?id=${medicalPrescriptions.medicalprescriptionId}"><i class="bi bi-pen-fill" style="color: darkturquoise;"></i></a>
                    <a onclick="deleteMedicine(${medicalPrescriptions.medicalprescriptionId})" href=""><i class="bi bi-trash3-fill" style="color: red;"></i></a>
                    </td>
                 </tr>                    
            </tbody>
         </table>
         `;
            }else{
                alert("El usuario no tiene fórmula medica asignada")
            }
        }
        
    } 
    
}