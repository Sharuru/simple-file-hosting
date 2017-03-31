package self.srr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharuru on 2017/03/30.
 */

public class Message {
    String msg;

    List<String> markdownComm = new ArrayList<>();

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getMarkdownComm() {
        return markdownComm;
    }

    public void setMarkdownComm(List<String> markdownComm) {
        this.markdownComm = markdownComm;
    }
}
