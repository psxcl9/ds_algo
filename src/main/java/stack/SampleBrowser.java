package stack;

import stack.linked.StackBasedoOnLinkedList;

public class SampleBrowser {

    private String currentPage;
    //可供后退的栈
    private StackBasedoOnLinkedList back;
    //可供前进的栈
    private StackBasedoOnLinkedList forward;

    public SampleBrowser() {
        currentPage = "";
        back = new StackBasedoOnLinkedList();
        forward = new StackBasedoOnLinkedList();
    }

    public void open(String page) {
        if (this.currentPage != null) {
            back.push(page.hashCode());
            forward.clear();
        }
        setCurrentPage(page);
    }

    public String goBack() {
        if (canGoBack()) {
            int pageHash = back.pop();
            forward.push(this.currentPage.hashCode());
            setCurrentPage(String.valueOf(pageHash));
            return String.valueOf(pageHash);
        }
        return "";
    }

    public String goForward() {
        if (canGoForward()) {
            int pageHash = forward.pop();
            back.push(this.currentPage.hashCode());
            setCurrentPage(String.valueOf(pageHash));
            return String.valueOf(pageHash);
        }
        return "";
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
        System.out.println("当前页面" + currentPage);
    }

    private boolean canGoBack() {
        return back.top != null;
    }

    private boolean canGoForward() {
        return forward.top != null;
    }


}
