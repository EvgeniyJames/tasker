package util;
import com.insart.tasker.model.Tasklist;

public class TasklistUtil {
    /**
     * Добавление {@link com.insart.tasker.model.Tasklist} в БД
     * @param title title
     * @param idAuthor idAuthor
     * @param idExecutor idExecutor
     * @return {@link com.insart.tasker.model.Tasklist} в БД
     */
    public static Tasklist createTasklist(String title,Long idAuthor,Long idExecutor) {
       Tasklist tasklist=new Tasklist();
        tasklist.setTitle(title);
        tasklist.setIdAuthor(idAuthor);
        tasklist.setIdExecutor(idExecutor);
        return tasklist;
    }
}
