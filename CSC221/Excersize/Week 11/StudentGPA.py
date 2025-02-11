# StudentGPA.py
# Mason Anderson
# Highest GPA students

def highestGPA(students):
    gpa = []

    for student in students:
        gpa.append(float(student[2]))

    highest = max(gpa)
    index = gpa.index(highest)

    return index

def main():

    file = open("students.txt","r")
    students = []

    for line in file:
        info = line.rstrip().split(",")
        students.append(info)

    index = highestGPA(students)
    print(students[index][0])
        
        

if __name__ == "__main__":
    main()
