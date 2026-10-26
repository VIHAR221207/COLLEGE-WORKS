; ============================================================================
; Experiment 4: 8086 Assembly - Basic Logical Operations (8-bit)
; Lab: Computer Organization & Architecture Lab
; ============================================================================

DATA SEGMENT
    NUM1    DB 92H       ; First 8-bit data (10010010)
    NUM2    DB 6AH       ; Second 8-bit data (01101010)
    RES_AND DB ?         ; To store AND result (02H)
    RES_OR  DB ?         ; To store OR result (FAH)
    RES_XOR DB ?         ; To store XOR result (F8H)
    RES_NOT DB ?         ; To store NOT result of NUM1 (6DH)
DATA ENDS

CODE SEGMENT
    ASSUME CS:CODE, DS:DATA
START:
    ; Initialize Data Segment
    MOV AX, DATA
    MOV DS, AX

    ; Bitwise AND Operation
    MOV AL, NUM1         ; Load NUM1 into AL
    AND AL, NUM2         ; AL = AL AND NUM2
    MOV RES_AND, AL      ; Store result in memory

    ; Bitwise OR Operation
    MOV AL, NUM1         ; Reload NUM1 into AL
    OR AL, NUM2          ; AL = AL OR NUM2
    MOV RES_OR, AL       ; Store result in memory

    ; Bitwise XOR Operation
    MOV AL, NUM1         ; Reload NUM1 into AL
    XOR AL, NUM2         ; AL = AL XOR NUM2
    MOV RES_XOR, AL      ; Store result in memory

    ; Bitwise NOT Operation (Logical Complement)
    MOV AL, NUM1         ; Reload NUM1 into AL
    NOT AL               ; AL = NOT AL
    MOV RES_NOT, AL      ; Store result in memory

    ; Terminate Program
    MOV AH, 4CH
    INT 21H
CODE ENDS
END START
