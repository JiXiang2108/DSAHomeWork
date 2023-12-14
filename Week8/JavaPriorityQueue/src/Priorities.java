import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int compareTo(Student o){

        if (o.cgpa == this.cgpa && o.name == this.name) {
            return Integer.compare(o.id, this.id);
        } else if (o.cgpa == this.cgpa){
            return this.name.compareTo(o.name);
        } else {
            return Double.compare(o.cgpa, this.cgpa);
        }
    }
}
class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> q = new PriorityQueue<>();
        List<Student> studentList = new ArrayList<>();
        for (String event: events) {
            Scanner scanner = new Scanner(event);
            String s = scanner.next();
            if (s.equals("ENTER")) {
                String name = scanner.next();
                Double cgpa = scanner.nextDouble();
                int id = scanner.nextInt();
                Student student = new Student(id, name, cgpa);
                q.add(student);
            } else {
                q.poll();
            }
        }
        while (!q.isEmpty()){
            studentList.add(q.poll());
        }
        return studentList;
    }
}