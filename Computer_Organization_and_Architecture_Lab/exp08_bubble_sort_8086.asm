; ============================================================================
; Experiment 8: 8086 Assembly - Sort 8-bit Array in Ascending Order (Bubble Sort)
; Lab: Computer Organization & Architecture Lab
; ============================================================================

.MODEL SMALL
.STACK 100H
.DATA
    ARRAY DB 45H, 12H, 78H, 34H    ; Array of 8-bit numbers
    COUNT EQU 4                   ; Number of elements in the array (N)

.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX
    MOV CX, COUNT - 1             ; Outer loop runs (N-1) times

OUTER_LOOP:
    MOV DX, CX                    ; Set inner loop iteration count
    LEA SI, ARRAY                 ; Load base address of ARRAY into SI

INNER_LOOP:
    MOV AL, [SI]                  ; Load current element into AL
    CMP AL, [SI+1]                ; Compare adjacent elements
    JBE NO_SWAP                   ; Skip swap if AL <= [SI+1] (already in order)

    ; Swap elements if AL > [SI+1]
    XCHG AL, [SI+1]
    MOV [SI], AL

NO_SWAP:
    INC SI                        ; Move to next adjacent element pair
    DEC DX                        ; Decrement inner loop counter
    JNZ INNER_LOOP                ; Continue inner loop until DX == 0

    LOOP OUTER_LOOP               ; Decrement CX and continue outer loop

    ; Program termination
    MOV AH, 4CH
    INT 21H
MAIN ENDP
END MAIN
