import sys
from PyQt5.QtWidgets import QApplication, QMainWindow
from PyQt5 import QtWidgets

from Test import Ui_Stack


class MainWindow:
    def __init__(self):
        self.main_win = QMainWindow()
        self.uic = Ui_Stack()
        self.uic.setupUi(self.main_win)
        self.uic.But_rev.clicked.connect(self.reverse)
        self.uic.but_cal.clicked.connect(self.infix_to_postfix)
        self.string_data = []

    def reverse(self):
        if len(self.string_data) != 0:
            self.string_data = []
        x = self.uic.in_string.text()

        for i in x:
            self.string_data.append(i)
        print(self.string_data)
        self.uic.out_string.setText(str("".join([x[-i - 1] for i in range(len(x))])))

    def infix_to_postfix(self):
        OPERATORS = {'+', '-', '*', '/', '(', ')', '^'}  # set of operators
        PRIORITY = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}  # dictionary having priorities
        x = self.uic.infix.text()
        stack = []  # initially stack empty
        output = ''  # initially output empty
        for ch in x:
            if ch not in OPERATORS:  # if an operand then put it directly in postfix expression
                output += ch
            elif ch == '(':  # else operators should be put in stack
                stack.append('(')
            elif ch == ')':
                while stack and stack[-1] != '(':
                    output += stack.pop()
                stack.pop()
            else:
                # lesser priority can't be on top on higher or equal priority
                # so pop and put in output
                while stack and stack[-1] != '(' and PRIORITY[ch] <= PRIORITY[stack[-1]]:
                    output += stack.pop()
                stack.append(ch)
        while stack:
            output += stack.pop()
        print(x, output)
        self.uic.portfix.setText(str(output))
        try:
            y = eval(x)
            if int(y) == eval(x):
                y = int(y)
        except :
            y = 'Biểu thức đầu vào không thể tính toán được'

        self.uic.answer.setText(str(y))

    def show(self):
        self.main_win.show()


if __name__ == "__main__":
    app = QApplication(sys.argv)
    main_win = MainWindow()
    main_win.show()
    sys.exit(app.exec())
