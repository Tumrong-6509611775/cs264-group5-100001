
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

                username : formData.get('studentId'),
                studentFirstName: formData.get('studentFirstName'),
                studentLastName: formData.get('studentLastName'),
                nameTitles: formData.get('nameTitles'),
                studentYear: formData.get('studentYear'),
                studyField: formData.get('studyField'),
                mobilePhone: formData.get('mobilePhone'),
                phone: formData.get('phone'),
                advisor: formData.get('advisor'),
                addressNumber: formData.get('addressNumber'),
                moo: formData.get('moo'),
                tumbol: formData.get('tumbol'),
                amphur: formData.get('amphur'),
                province: formData.get('Province'),
                postalcode: formData.get('postalCode'),
            };
            var JSON_user = JSON.stringify(user);
            fetch('/path/form/index', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON_user
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
            console.log(JSON_user);

                /* cause: formData.get('cause')*/
            const addTable = document.getElementById("addSubjectList");
            const dropTable = document.getElementById("dropSubjectList");

            var addNum = addTable.rows.length;
            var dropNum = dropTable.rows.length;
            //console.log(addNum);
           // console.log(dropNum);
            for(let i = 1 ; i < addNum ; i++){
                    var addEachsubject = {
                        username : formData.get('studentId'),
                        subjectCode : addSubjectList.rows[i].cells[0].querySelector('input').value,
                        subjectName : addSubjectList.rows[i].cells[1].querySelector('input').value,
                        subjectSection : addSubjectList.rows[i].cells[2].querySelector('input').value,
                        subjectDate : addSubjectList.rows[i].cells[3].querySelector('input').value,
                        subjectCredit : addSubjectList.rows[i].cells[4].querySelector('input').value,
                        subjectTeacher : addSubjectList.rows[i].cells[5].querySelector('input').value,
                        type : "Register",
                        cause : formData.get('cause')

                    }
                    var JSON_subject = JSON.stringify(addEachsubject);
                    console.log(JSON_subject);
                    fetch('/path/form/subject', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON_subject
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

            }
            for(let i = 1 ; i < dropNum ; i++){
                var dropEachsubject = {
                    username : formData.get('studentId'),
                    subjectCode : dropSubjectList.rows[i].cells[0].querySelector('input').value,
                    subjectName : dropSubjectList.rows[i].cells[1].querySelector('input').value,
                    subjectSection : dropSubjectList.rows[i].cells[2].querySelector('input').value,
                    subjectDate : dropSubjectList.rows[i].cells[3].querySelector('input').value,
                    subjectCredit : dropSubjectList.rows[i].cells[4].querySelector('input').value,
                    subjectTeacher : dropSubjectList.rows[i].cells[5].querySelector('input').value,
                    type : "Withdraw",
                    cause : formData.get('cause')

                    
                }

                var JSON_subject = JSON.stringify(dropEachsubject);
                console.log(JSON_subject);
                fetch('/path/form/subject', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON_subject
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
                    

        }




            

     
            
            
            console.log("wqer");
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