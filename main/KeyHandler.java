package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean shotKeyPressed, upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    GamePanel gp;
    boolean checkDraw = false;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    public KeyHandler() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (gp.gameState == gp.titleState) {
            // title state
            titleState(code);
        } else if (gp.gameState == gp.playState) {
            // PLAY STATE
            playState(code);
            // DEBUG

        } else if (gp.gameState == gp.pauseState) {
            // PAUSE STATE
            pauseState(code);
        } else if (gp.gameState == gp.dialogueState) {
            // DIALOGUE STATE
            dialoguestate(code);
        } else if (gp.gameState == gp.characterState) {
            // character State
            characterState(code);
        } else if (gp.gameState == gp.optionState) {
            // OPTION STATE
            optionState(code);
        }
    }

    public void titleState(int code) {
        if (code == KeyEvent.VK_W) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = 2;
            }
        }
        if (code == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 2) {
                gp.ui.commandNum = 0;
            }
        }
        if (code == KeyEvent.VK_ENTER) {
            if (gp.ui.commandNum == 0) {
                gp.gameState = gp.playState;
                gp.playMusic(0);
            }
            if (gp.ui.commandNum == 1) {
                // later
            }
            if (gp.ui.commandNum == 2) {
                System.exit(0);
            }
        }
    }

    public void playState(int code) {

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_P) {
            gp.gameState = gp.pauseState;
        }
        if (code == KeyEvent.VK_C) {
            gp.gameState = gp.characterState;
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
        if (code == KeyEvent.VK_F) {
            shotKeyPressed = true;
        }
        if (code == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.optionState;
        }

        // debug
        if (code == KeyEvent.VK_T) {
            if (checkDraw == false) {
                checkDraw = true;
            } else if (checkDraw == true) {
                checkDraw = false;
            }
        }
    }

    public void pauseState(int code) {
        if (code == KeyEvent.VK_P) {
            gp.gameState = gp.playState;
        }
    }

    public void dialoguestate(int code) {
        if (code == KeyEvent.VK_ENTER) {
            gp.gameState = gp.playState;
        }
    }

    public void optionState(int code) {
        if (code == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.playState;
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }

        int maxCommandNum = 0;
        switch (gp.ui.subState) {
            case 0:
                maxCommandNum = 4;
                break;
            case 2:
                maxCommandNum = 1;
                break;

            default:
                break;
        }
        if (code == KeyEvent.VK_W) {
            gp.ui.commandNum--;
            // gp.playSE(maxCommandNum);
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = maxCommandNum;
            }
        }
        if (code == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            // gp.playSE(maxCommandNum);
            if (gp.ui.commandNum > maxCommandNum) {
                gp.ui.commandNum = 0;
            }
        }
        if (code == KeyEvent.VK_A) {
            if (gp.ui.subState == 0) {
                if (gp.ui.commandNum == 0 && gp.music.volumeScale > 0) {
                    gp.music.volumeScale--;
                    gp.music.checkVolume();
                    // gp.playSE(maxCommandNum);
                }

                if (gp.ui.commandNum == 1 && gp.SFX.volumeScale > 0) {
                    gp.SFX.volumeScale--;
                    // gp.playSE(maxCommandNum);
                }
            }
        }
        if (code == KeyEvent.VK_D) {
            if (gp.ui.subState == 0) {
                if (gp.ui.commandNum == 0 && gp.music.volumeScale < 5) {
                    gp.music.volumeScale++;
                    gp.music.checkVolume();
                    // gp.playSE(maxCommandNum);
                }
                if (gp.ui.commandNum == 1 && gp.SFX.volumeScale < 5) {
                    gp.SFX.volumeScale++;
                    // gp.playSE(maxCommandNum);
                }
            }
        }

    }

    public void characterState(int code) {
        if (code == KeyEvent.VK_C) {
            gp.gameState = gp.playState;
        }
        if (code == KeyEvent.VK_W) {
            if (gp.ui.slotRow != 0) {
                gp.ui.slotRow--;
            }
        }
        if (code == KeyEvent.VK_S) {
            if (gp.ui.slotRow != 3) {
                gp.ui.slotRow++;

            }
        }
        if (code == KeyEvent.VK_A) {
            if (gp.ui.slotCol != 0) {
                gp.ui.slotCol--;
            }
        }
        if (code == KeyEvent.VK_D) {
            if (gp.ui.slotCol != 4) {
                gp.ui.slotCol++;
            }
        }
        if (code == KeyEvent.VK_ENTER) {
            gp.player.selectItem();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        // if (code == KeyEvent.VK_ENTER) {
        // enterPressed = false;
        // }
        if (code == KeyEvent.VK_F) {
            shotKeyPressed = false;
        }
    }
    // Character State
}
