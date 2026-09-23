class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        deque<string> s1, s2;
        stringstream ss1(sentence1), ss2(sentence2);
        string word;

        while (ss1 >> word) {
            s1.push_back(word); }

        while (ss2 >> word) {
            s2.push_back(word); }

        while (!s1.empty() && !s2.empty() && s1.front() == s2.front()) {
            s1.pop_front();
            s2.pop_front(); }

        while (!s1.empty() && !s2.empty() && s1.back() == s2.back()) {
            s1.pop_back();
            s2.pop_back(); }

        return s1.empty() || s2.empty();
    }
};