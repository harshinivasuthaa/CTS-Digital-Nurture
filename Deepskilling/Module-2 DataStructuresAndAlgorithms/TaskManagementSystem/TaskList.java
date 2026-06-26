class TaskList{
    Task head;

    void addTask(Task newTask){

        if (head == null){
            head = newTask;
            return;
        }
        Task temp = head;

        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newTask;
    }

    void traverse(){

        Task temp = head;
        while (temp != null){
            temp.display();
            temp = temp.next;
        }
    }

    Task search(int id){

        Task temp = head;
        while (temp != null){
            if (temp.taskId == id){
                return temp;
            }

            temp = temp.next;
        }
        return null;
    }

    void delete(int id){

        if (head == null) return;
        if (head.taskId == id){
            head = head.next;
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id){
            temp = temp.next;
        }
        if (temp.next == null){
            System.out.println("Task not found");
            return;
        }
        temp.next = temp.next.next;
    }
}