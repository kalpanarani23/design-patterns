package stackOverFlow.enums;

public enum VoteType {
    UP_VOTE(4),
    DOWN_VOTE(-3);

    private final int voteValue;

    VoteType(int voteValue) {
        this.voteValue = voteValue;
    }

    public int getVoteValue() {
        return voteValue;
    }
}
