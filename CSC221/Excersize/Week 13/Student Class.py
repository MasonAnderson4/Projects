# Student Class.py
# Mason Anderson
# creates a class for a student

class Student:

    def __init__(self,first_name,last_name,net_id,major,credit_hours,quality_points,courses,preferred_name):
        self.first_name = first_name
        self.last_name = last_name
        self.net_id = net_id
        self.major = major
        self.credit_hours = credit_hours
        self.quality_points = quality_points
        self.courses = courses
        self.preferred_name = preferred_name
        self.gpa = quality_points / credit_hours

    def declareMajor(self, major):
        self.major = major

    def setPreferredName(self, preferred_name):
        self.preferred_name = preferred_name

    def netID(self):
        return self.net_id

    def creditHours(self):
        return self.credit_hours

    def qualityPoints(self):
        return self.quality_points
    
    def coursesTaken(self):
        return self.courses

    def addCourse(self,credit_hours,quality_points):
        self.credit_hours += credit_hours
        self.quality_points += quality_points
        

    def getGPA(self):
        self.gpa = self.quality_points / self.credit_hours
        return self.gpa

    def __str__(self):
        return "Hello {}, your declared major is {}, and you have a GPA of {}.".format(self.preferred_name,self.major,self.gpa)
        

        
def main():

    student = Student("Mason","Anderson","mha74231","CompSci",30,115,8,"Mason")
    print(student)
    


if __name__ == "__main__":
    main()
