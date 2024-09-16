package com.it.dsa.datastrucuture.stack;

public class DriverClass {

    public static void main(String[] args) {
        CustomStack<String> st = new CustomStack<>();

        st.push("abc");
        st.push("def");
        st.push("ghi");

        st.print();
        st.pop();
        st.print();
        st.pop();
        st.print();
        st.pop();
        st.print();
        st.pop();
    }
}
