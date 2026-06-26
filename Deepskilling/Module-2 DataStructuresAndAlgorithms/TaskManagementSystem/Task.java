class Task{
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int Id, String Name, String sts){
        this.taskId=Id;
        this.taskName=Name;
        this.status=sts;
        this.next=null;
    }

    void display(){
        System.out.println(taskId+" "+taskName+" "+status);
    }
}