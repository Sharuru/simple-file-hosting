package self.srr.model;

/**
 * Message response JSON model
 * <p>
 * Created by Sharuru on 2017/03/30.
 */

public class Message {

    private String msg;
    private String markdownComm;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMarkdownComm() {
        return markdownComm;
    }

    public void setMarkdownComm(String markdownComm) {
        this.markdownComm = markdownComm;
    }
}
