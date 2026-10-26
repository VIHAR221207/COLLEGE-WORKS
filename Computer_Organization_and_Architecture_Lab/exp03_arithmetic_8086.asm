; ============================================================================
; Experiment 3: 8086 Assembly - Basic Arithmetic Operations (8-bit)
; Lab: Computer Organization & Architecture Lab
; ============================================================================

.MODEL SMALL
.STACK 100H
.DATA
    NUM1 DB 00001000B    ; 8 in binary (00001000)
    NUM2 DB 00000100B    ; 4 in binary (00000100)
    SUM  DB ?            ; To store addition result
    DIFF DB ?            ; To store subtraction result
    PROD DW ?            ; To store multiplication result (16-bit)
    QUOT DB ?            ; To store division quotient
    REM  DB ?            ; To store division remainder

.CODE
MAIN PROC
    ; Initialize Data Segment
    MOV AX, @DATA
    MOV DS, AX

    ; 1. ADDITION (8 + 4 = 12)
    MOV AL, NUM1
    ADD AL, NUM2
    MOV SUM, AL

    ; 2. SUBTRACTION (8 - 4 = 4)
    MOV AL, NUM1
    SUB AL, NUM2
    MOV DIFF, AL

    ; 3. MULTIPLICATION (8 * 4 = 32)
    MOV AL, NUM1
    MOV BL, NUM2
    MUL BL
    MOV PROD, AX

    ; 4. DIVISION (8 / 4 = QUOT: 2, REM: 0)
    MOV AL, NUM1
    MOV AH, 00H          ; Clear AH for dividend
    MOV BL, NUM2
    DIV BL
    MOV QUOT, AL         ; AL = Quotient
    MOV REM, AH          ; AH = Remainder

    ; Terminate Program
    MOV AH, 4CH
    INT 21H
MAIN ENDP
END MAIN
