; ============================================================================
; Experiment 9: 8086 Assembly - Block Transfer of Data using SI and DI
; Lab: Computer Organization & Architecture Lab
; ============================================================================

.MODEL SMALL
.STACK 100H
.DATA
    SRC_BLOCK  DB 10H, 20H, 30H, 40H, 50H    ; Source Data Block
    COUNT      EQU 5                         ; Number of bytes to transfer
    DEST_BLOCK DB 5 DUP(0)                   ; Destination Data Block initialized to 0

.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX            ; Step 2: Initialize Data Segment
    MOV ES, AX            ; Step 2: Initialize Extra Segment
    LEA SI, SRC_BLOCK     ; Step 3: Load SI with starting address of source block
    LEA DI, DEST_BLOCK    ; Step 4: Load DI with starting address of destination block
    MOV CX, COUNT         ; Step 5: Load CX with transfer count
    CLD                   ; Clear Direction Flag (DF=0) for auto-incrementing SI/DI
    REP MOVSB             ; Step 6: Transfer bytes from DS:SI to ES:DI

    ; Step 7: Terminate Program
    MOV AH, 4CH
    INT 21H
MAIN ENDP
END MAIN
