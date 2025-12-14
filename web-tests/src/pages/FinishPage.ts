import { Page } from "@playwright/test";
import { BasePage } from "../core/BasePage";

export class FinishPage extends BasePage{
    private readonly finishMesagge;

    constructor(page: Page) {
        super(page);
        this.finishMesagge = page.locator('.complete-header');
    }

    async getThankYouMessage(): Promise<string> {
        return this.getText(this.finishMesagge)        
    }
}