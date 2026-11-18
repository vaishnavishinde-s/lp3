
// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract StudentData {

    // Student structure
    struct Student {
        uint rollNo;
        string name;
        uint marks;
    }

    // Array to store students
    Student[] public students;

    // Add student details
    function addStudent(
        uint _rollNo,
        string memory _name,
        uint _marks
    ) public {
        students.push(Student({
            rollNo: _rollNo,
            name: _name,
            marks: _marks
        }));
    }

    // Get student details
    function getStudent(uint _index)
        public
        view
        returns (uint, string memory, uint)
    {
        require(_index < students.length, "Invalid student index");

        Student storage s = students[_index];

        return (s.rollNo, s.name, s.marks);
    }

    // Get total number of students
    function getStudentCount() public view returns (uint) {
        return students.length;
    }

    // Fallback function
    fallback() external payable {
    }

    // Receive Ether
    receive() external payable {
    }
}

