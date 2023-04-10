// openaiClient.ts
import { Configuration, OpenAIApi } from "openai";

const apiKey = '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';
const configuration = new Configuration({
    apiKey: apiKey,
});

const openai = new OpenAIApi(configuration);

export default openai;
