package me.aflak.libraries.ui.chat.view;


public interface ChatView {
    void setStatus(String status);
    void setStatus(int resId);
    void appendMessage(String message);
    void enableHWButton(boolean enabled);
    void showToast(String message);
}
