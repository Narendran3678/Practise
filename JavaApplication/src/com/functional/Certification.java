package com.functional;

public class Certification {
   String studId;
   String test;
   int marks;

   public Certification(String studId, String test, int marks) {
       this.studId = studId;
       this.test = test;
       this.marks = marks;
   }

   public String toString() {
       return "{" + studId + ", " + test + ", " + marks + "}";
   }

   public String getStudId() {
       return studId;
   }

   public String getTest() {
       return test;
   }

   public int getMarks() {
       return marks;
   }
}
