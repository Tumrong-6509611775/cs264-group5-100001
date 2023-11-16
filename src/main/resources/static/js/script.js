
function addRow(tableId) {
    const table = document.getElementById(tableId);

    // Check if the table already has 10 rows
    if (table.rows.length >= 11) {
        alert('You cannot add more than 10 rows.');
        return;
    }

    const newRow = table.insertRow();
    for (let i = 0; i < 6; i++) {
        const cell = newRow.insertCell(i);
        const input = document.createElement('input');
        switch (i) {
            case 2:
                input.type = 'number';
                break;
            case 4:
                input.type = 'number';
                break;
            default:
                input.type = 'text';
        }

        input.name = `${tableId}[${table.rows.length}][${i}]`;
        cell.appendChild(input);
    }
}


function removeLastRow(tableId) {
	const table = document.getElementById(tableId);
	if (table.rows.length > 1) {
		table.deleteRow(table.rows.length - 1);
	}
}

function submitForm() {
event.preventDefault();
//console.log(addSubjectList.rows[1].cells[0].querySelector('input').value);
  const formData = new FormData(document.getElementById('userForm'))
  const user = {
  				date: formData.get('Date'),
                nameTitles: formData.get('nameTitles'),
                studentFirstName: formData.get('studentFirstName'),
                studentLastName: formData.get('studentLastName'),
                studentId: formData.get('studentId'),
                studentYear: formData.get('studentYear'),
                studyField: formData.get('studyField'),
                advisor: formData.get('advisor'),
                addressNumber: formData.get('addressNumber'),
                moo: formData.get('moo'),
                tumbol: formData.get('tumbol'),
                amphur: formData.get('amphur'),
                Province: formData.get('Province'),
                postalCode: formData.get('postalCode'),
                mobilePhone: formData.get('mobilePhone'),
                phone: formData.get('phone'),
                cause: formData.get('cause'),

                addsubject : [],
                dropsubject : []
            }; 
            const addTable = document.getElementById("addSubjectList");
            const dropTable = document.getElementById("dropSubjectList");

            var addNum = addTable.rows.length;
            var dropNum = dropTable.rows.length;
            //console.log(addNum);
           // console.log(dropNum);
            for(let i = 1 ; i < addNum ; i++){
                    var addEachsubject = {
                        addsubjectcode : addSubjectList.rows[i].cells[0].querySelector('input').value,
                        addsubjectName : addSubjectList.rows[i].cells[1].querySelector('input').value,
                        addsubjectSection : addSubjectList.rows[i].cells[2].querySelector('input').value,
                        addsubjectDate : addSubjectList.rows[i].cells[3].querySelector('input').value,
                        addsubjectCredit : addSubjectList.rows[i].cells[4].querySelector('input').value,
                        addsubjectTeacher : addSubjectList.rows[i].cells[5].querySelector('input').value,
                       
                    }
                    user.addsubject.push(addEachsubject);
            }
            for(let i = 1 ; i < dropNum ; i++){
                var dropEachsubject = {
                    dropsubjectcode : dropSubjectList.rows[i].cells[0].querySelector('input').value,
                    dropsubjectName : dropSubjectList.rows[i].cells[1].querySelector('input').value,
                    dropsubjectSection : dropSubjectList.rows[i].cells[2].querySelector('input').value,
                    dropsubjectDate : dropSubjectList.rows[i].cells[3].querySelector('input').value,
                    dropsubjectCredit : dropSubjectList.rows[i].cells[4].querySelector('input').value,
                    dropsubjectTeacher : dropSubjectList.rows[i].cells[5].querySelector('input').value,
                    
                }
                user.dropsubject.push(dropEachsubject);
        }



                  
            var JSON_user = JSON.stringify(user);
            console.log(JSON_user);
        fetch('/form', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            })
            .then(response => {
                if (response.ok) {
                    document.getElementById('result').innerText = 'User saved successfully.';
                    console.log("GOOD");
                } else {
                    /*response.text().then(errorMessage => {
                        document.getElementById('result').innerText = 'An error occurred while saving the user. Error message: ' + errorMessage;
                    });*/
                }
            })
            .catch(error => {
                //console.error('Error:', error);
                //document.getElementById('result').innerText = 'An error occurred while saving the user.';
            });
            //console.log("wqer");
}

const userForm = document.getElementById('userForm');
userForm.addEventListener('submit', submitForm);



// เพิ่มฟังก์ชัน chooseFile() เพื่อเปิด input file

// เรียกใช้ modal เมื่อคลิกที่ปุ่ม Upload File
// เพิ่มฟังก์ชัน JavaScript เพื่อเปิด modal
document.getElementById("customUploadBtn").addEventListener("click", function () {
    document.getElementById("fileUploadModal").style.display = "block";
});

// เพิ่มฟังก์ชัน JavaScript เพื่อปิด modal
function closeModal() {
    document.getElementById("fileUploadModal").style.display = "none";
}
// เพิ่มฟังก์ชัน chooseFile() เพื่อเปิด input file
function chooseFile() {
    const fileInput = document.getElementById("fileInput");
    fileInput.click();
    updateFileName();
}
// Function to delete the selected file
function deleteSelectedFile() {
    // Reset the file input
    document.getElementById('fileInput').value = '';

    // Clear the selected file name in the modal
    document.getElementById('selectedFileName').innerText = '';

    // Clear the selected file name at the top of the page
    document.getElementById('selectedFileNameTop').innerText = '';
}

// Function to update the selected file name in the modal
function updateFileName() {
    const fileInput = document.getElementById('fileInput');
    const selectedFileName = document.getElementById('selectedFileName');
    const selectedFileNameTop = document.getElementById('selectedFileNameTop');

    // Display the selected file name
    // Check if a file is selected
    if (fileInput.files.length > 0) {
        selectedFileName.textContent = `Selected File: ${fileInput.files[0].name}`;
        selectedFileNameTop.textContent = `Selected File: ${fileInput.files[0].name}`;
    } else {
        // Clear the content if no file is selected
        selectedFileName.textContent = "";
        selectedFileNameTop.textContent = "";
    }

}




